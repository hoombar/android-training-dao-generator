package Entity;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;
import Entity.pattern.GenEntity;

public class ConferenceEntity extends GenEntity {

	public ConferenceEntity(Schema schema) {
		super(schema);
	}

	@Override
	public Entity addEntity() {
		Entity conference = mSchema.addEntity("Conference");
		
		conference.addLongProperty("id").primaryKey().autoincrement();
		
		conference.addStringProperty("name");
		conference.addLongProperty("capacity");
			
		return conference;
	}

}
