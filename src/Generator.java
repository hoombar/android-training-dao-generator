import java.io.IOException;

import Entity.ConferenceEntity;
import Entity.RoomEntity;
import Entity.SpeakerEntity;
import Entity.TimeslotEntity;
import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Generator extends DaoGenerator {

	public Generator() throws IOException {
	}

	/**
	 * All entities are added to the schema, any data relations ar defined within
	 * the entity itself
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// the defined schema location and dao package will dictate where
		// the generated files get placed in the target project
		Schema schema = new Schema(3, "net.rdyonline.android_training.orm");
        schema.setDefaultJavaPackageDao("net.rdyonline.android_training.orm.dao");
        schema.enableKeepSectionsByDefault();
        
        // each of the entities added from the ERD are inserted here
		Entity conference = new ConferenceEntity(schema).addSerializableEntity();
        Entity room = new RoomEntity(schema, conference).addSerializableEntity();
        Entity speaker = new SpeakerEntity(schema).addSerializableEntity();
        new TimeslotEntity(schema, speaker, room).addSerializableEntity();
        
        try {
        	// relative path to the project you want to create the ORM files
        	// for is specified here
            new DaoGenerator().generateAll(schema, "../android-training/src");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
