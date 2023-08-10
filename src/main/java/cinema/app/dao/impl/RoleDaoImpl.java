package cinema.app.dao.impl;

import cinema.app.dao.AbstractDao;
import cinema.app.dao.RoleDao;
import cinema.app.exception.DataProcessingException;
import cinema.app.model.Role;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getByName(String roleName) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Role r "
                                        + "WHERE r.roleName = :roleName", Role.class)
                                        .setParameter("roleName", Role.RoleName.valueOf(roleName))
                                        .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find Role with name: " + roleName, e);
        }
    }
}
