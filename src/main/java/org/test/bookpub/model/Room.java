package org.test.bookpub.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * This class represents a rental room on property management system.
 *
 * @author Ludovic Dewailly
 */
@XmlType(name="room")
public class Room {

    private long id;
    private RoomCategory roomCategory;
    private String name;
    private String description;

    @XmlElement(name="id")
    public long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    @XmlElement
    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }
   
    @XmlElement(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
//    @Override
//    public String toString() {
//        return getId() + " : " + getName() +" : " + getDescription();
//    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
