package business;

import rest.model.Insumo;

/**
 * Created by Livia on 12/06/2016.
 */
public interface InsumosService {
    boolean create(final Insumo insumo);
    Insumo update(final Insumo insumo);
    Insumo read(final String insumoId);
    boolean delete(final String origem, final int codigo);
}
