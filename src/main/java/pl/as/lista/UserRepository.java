package pl.as.lista;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public List<User> userList = new ArrayList<>() ;

    public UserRepository() {
        userList.add(new User("Jacek", "Placek", 23));
        userList.add(new User("Tomek", "Paluch", 22));
        userList.add(new User("Stefek", "Burczymucha", 21));
    }

    public List<User> getAll() {
        return userList;
    }

    public void add(User user) {
        userList.add(user);
    }
}
