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

	public static void main(String[] args) {
		
		Schema schema = new Schema(3, "net.rdyonline.android_training.orm");
        schema.setDefaultJavaPackageDao("net.rdyonline.android_training.orm.dao");
        schema.enableKeepSectionsByDefault();
        
        @SuppressWarnings("unused")
		Entity conference = new ConferenceEntity(schema).addSerializableEntity();
        Entity room = new RoomEntity(schema, conference).addSerializableEntity();
        Entity speaker = new SpeakerEntity(schema).addSerializableEntity();
        Entity timeslot = new TimeslotEntity(schema, speaker, room).addSerializableEntity();
        
        try {
            new DaoGenerator().generateAll(schema, "../android-training/src");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
