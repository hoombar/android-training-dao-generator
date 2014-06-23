package Entity.pattern;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;


public abstract class GenEntity implements IEntity {

	protected Schema mSchema;
	
	@SuppressWarnings("unused")
	private GenEntity() {};
	public GenEntity(Schema schema) {
		mSchema = schema;
	}
	
	/**
	 * If you want to store any of the entities to be processed
	 * later (for example, using priority-job-queue) then they
	 * will need to be serializable
	 * 
	 * @return
	 */
	public Entity addSerializableEntity() {
		Entity entity = addEntity();
		entity.implementsSerializable();
		
		return entity;
	}
	
	@Override
	public abstract Entity addEntity();

}
