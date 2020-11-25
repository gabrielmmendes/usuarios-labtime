package br.com.gabrielmmendes;

import br.com.gabrielmmendes.controller.UsuarioController;
import br.com.gabrielmmendes.repository.UsuarioRepository;
import static br.com.gabrielmmendes.PageableAssert.assertThatPageable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = UsuarioController.class) //testa somente a camada web, entre parenteses o controller que será testado, se não tiver nenhum testa todos os controllers da API
public class UsuarioControllerTest {

    @MockBean
    private UsuarioRepository repository;

    @Autowired
    private MockMvc mockMvc; //principal ponto de entrada para o controller

    @Test //teste de integração que mostra que a página e o tamanho dos parâmetros de consulta agora são avaliados e "injetados" no argumento Pageable do nosso método de controlador da web.
    public void usuariosPageTeste() throws Exception {
        mockMvc.perform(get("/usuarios")
            .param("page", "0")
            .param("size", "10"))
            .andExpect(status().isOk());

        ArgumentCaptor<Pageable> pageableCaptor = ArgumentCaptor.forClass(Pageable.class);
        verify(repository).findAll(pageableCaptor.capture());
        PageRequest pageable = (PageRequest) pageableCaptor.getValue();

        assertThatPageable(pageable).hasPageNumber(0);
        assertThatPageable(pageable).hasPageSize(10);
    }
}
