package pl.as.lista;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    User user1 = new User("Jacek", "Placek", 23);

    User user2 = new User("Tomek", "Paluch", 22);

    User user3 = new User("Stefek", "Burczymucha", 21);

    public List<User> userList = new ArrayList<>()
        {{ add(user1); add(user2); add(user3);}};

    public List<User> getAll() {
        return userList;
    }

    public void add(User user) {
        userList.add(user);
    }
}
