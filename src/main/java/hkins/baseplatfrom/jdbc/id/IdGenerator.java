package hkins.baseplatfrom.jdbc.id;

import java.util.List;

public abstract interface IdGenerator {
    
    public abstract String generateId();
    
    public abstract List<String> generateIdList(int count);
}
