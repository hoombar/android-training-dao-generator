package Entity;

import Entity.pattern.GenEntity;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class TimeslotEntity extends GenEntity {

	private Entity mSpeaker;
	private Entity mRoom;
	
	public TimeslotEntity(Schema schema, Entity speaker, Entity room) {
		super(schema);
		
		mSpeaker = speaker;
		mRoom = room;
	}

	@Override
	public Entity addEntity() {
		Entity timeslot = mSchema.addEntity("Timeslot");
		
		timeslot.addLongProperty("id").primaryKey().autoincrement();
		timeslot.addDateProperty("startTime");
		timeslot.addDateProperty("endTime");
		
		Property speaker = timeslot.addLongProperty("speaker").getProperty();
		Property room = timeslot.addLongProperty("room").getProperty();
		mSpeaker.addToMany(timeslot, speaker);
		mRoom.addToMany(timeslot, room);
		
		return timeslot;
	}
}
