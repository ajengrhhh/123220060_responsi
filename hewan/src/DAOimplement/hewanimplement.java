package DAOimplement;
import model.*;
import java.util.List;

/**
 *
 * @author
 */
public interface hewanimplement {
    public List<datahewan> getAll();
    public void insert(datahewan dh);
    public void update(datahewan dh);
    public void delete(String nama_pemilik);
}
