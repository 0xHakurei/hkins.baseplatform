package hkins.baseplatfrom.jdbc.id.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import hkins.baseplatfrom.jdbc.id.IdGenerator;

public class DefaultIdGenerator implements IdGenerator {

    @Override
    public String generateId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public List<String> generateIdList(int count) {
        List<String> idList = new ArrayList<String>();
        for(int i = 0; i < count; i++) {
            idList.add(generateId());
        }
        return idList;
    }

}
