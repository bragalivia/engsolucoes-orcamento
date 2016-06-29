package business;

import rest.model.Insumo;

/**
 * Created by Livia on 12/06/2016.
 */
public interface InsumoService {
    boolean create(final Insumo insumo);
    Insumo update(final Insumo insumo);
    Insumo read(final int code);
    boolean delete(final String source, final int code);
}
