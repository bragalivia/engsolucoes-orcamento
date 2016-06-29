package business.impl;

import business.ComposicoesService;
import dao.ComposicoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.model.Composicao;

/**
 * Created by Livia on 16/06/2016.
 */
@Component
public class ComposicoesServiceImpl implements ComposicoesService {
    @Autowired
    private ComposicoesRepository composicoesRepository;
    public boolean create(final Composicao composicao) {
        return composicoesRepository.create(composicao);
    }

    public Composicao update(final Composicao composicao) {
        return composicoesRepository.update(composicao);
    }

    public Composicao read(final int code) {
        return composicoesRepository.read(code);
    }

    public boolean delete(final String source, final int code) {
        return composicoesRepository.delete(source, code);
    }
}
