package tr.com.ege.se.cache;

import java.util.Map;

import tr.com.ege.se.model.UserDTO;

public interface UserCache {
     void put(UserDTO user);
     Map<String, UserDTO> getMap();
}
