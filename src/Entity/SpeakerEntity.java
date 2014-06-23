package Entity;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;
import Entity.pattern.GenEntity;

public class SpeakerEntity extends GenEntity {

	public SpeakerEntity(Schema schema) {
		super(schema);
	}

	@Override
	public Entity addEntity() {
		Entity speaker = mSchema.addEntity("Speaker");
		
		speaker.addLongProperty("id").primaryKey().autoincrement();
		
		speaker.addStringProperty("fname");
		speaker.addStringProperty("lname");
		speaker.addIntProperty("specialism");
		
		return speaker;
	}

}
