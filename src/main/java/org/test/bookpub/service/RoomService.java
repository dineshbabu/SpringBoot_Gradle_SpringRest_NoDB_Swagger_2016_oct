package org.test.bookpub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.test.bookpub.model.Room;

public class RoomService {

	public static List<Room> rooms = new ArrayList<>();
	
	public static void createRoom(Room room){
		rooms.add(room);
		printRooms();
	}

	private static void printRooms() {
		rooms.stream()
			.map(a -> a.getName())
			.forEach(System.out::println);
	}
	
	public static Room getRoom(int id) {
//		try{
			return rooms.stream()
					.filter(a -> (a.getId() == id))
					.collect(Collectors.toList())
					.get(0);
			
//		} catch(Exception e){
//			throw new RoomUnAvailableException("Room "+id+ " not available");
//		}
	}

	public static Room updateRoom(Room room, int id) {
		Room roomOld = getRoom(id);
		rooms.remove(roomOld);
		rooms.add(room);
		printRooms();
		return room;
	}

	public static void deleteRoom(int id) {
		Room room = getRoom(id);
		rooms.remove(room);
		printRooms();
		
	}
	
}
