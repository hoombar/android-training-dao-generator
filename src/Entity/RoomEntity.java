package Entity;

import Entity.pattern.GenEntity;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class RoomEntity extends GenEntity {

	private Entity mConference;
	
	public RoomEntity(Schema schema, Entity conference) {
		super(schema);
		
		mConference = conference;
	}

	@Override
	public Entity addEntity() {
		Entity room = mSchema.addEntity("Room");
		
		room.addLongProperty("id").primaryKey().autoincrement();
		room.addStringProperty("name");
		room.addLongProperty("capacity");
		
		Property conference = room.addLongProperty("conference").getProperty();
		mConference.addToMany(room, conference);
		
		return room;
	}

}
