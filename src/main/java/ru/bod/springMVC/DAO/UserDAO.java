package ru.bod.springMVC.DAO;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bod.springMVC.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Alishev
 */
@Component
public class UserDAO {
    public static int PEOPLE_COUNT;
    private List<User> people;

    {
        people = new ArrayList<>();

        people.add(new User(++PEOPLE_COUNT, "Tom","1234"));
        people.add(new User(++PEOPLE_COUNT, "Bob","1234"));

    }

    public void save(User user){
        user.setId(++PEOPLE_COUNT);
        people.add(user);
    }

    public List<User> index() {
        return people;
    }

    public User show(int id) {
        return people.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void update(int id, User user) {
        User user_searches = show(id);
        user_searches.setName(user.getName());
        user_searches.setPassword(user.getPassword());
    }

    public void delete(int id) {
        people.removeIf(p->p.getId()==id);
    }
}