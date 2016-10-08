package org.test.bookpub.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.test.bookpub.envelope.Envelope;
import org.test.bookpub.exception.RoomUnAvailableException;
import org.test.bookpub.model.Room;
import org.test.bookpub.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomsResource {


//  @RequestMapping(value = "/{roomId}", method = RequestMethod.GET)
//  public RoomDTO getRoom(@PathVariable("roomId") String roomId) {
//    RoomDTO room = ...
//    // omitted for sake of clarity
//    return room;
//  }
  
  @RequestMapping(value = "/{roomId}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
  public Envelope<Room> getRoom(@PathVariable("roomId") int roomId) {
	  String status  = "";
	  try{
		  	Room room = RoomService.getRoom(roomId);
		  	status = "Success";
		  	return new Envelope(status, room);		
		} catch(Exception e){
//			throw new RoomUnAvailableException("Room "+roomId+ " not avaiolable");
			status = "Failed";
			return new Envelope(status, e.getMessage());
		}
  }
  
  @RequestMapping(method = RequestMethod.POST, consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
		  			MediaType.APPLICATION_JSON_VALUE}, produces= MediaType.TEXT_PLAIN_VALUE)
  public void createRoom(@RequestBody Room room) {
	  RoomService.createRoom(room);
	  
  }
  
  @RequestMapping(value = "/{roomId}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, 
		  produces=MediaType.APPLICATION_JSON_VALUE)
  public Room updateRoom(@RequestBody Room room, @PathVariable("roomId") int roomId) {
    return RoomService.updateRoom(room, roomId);
  }
  
  @RequestMapping(value="/{roomId}", method=RequestMethod.DELETE)
  public void deleteRoom(@PathVariable("roomId") int roomId){
	  RoomService.deleteRoom(roomId);
  }
  
}