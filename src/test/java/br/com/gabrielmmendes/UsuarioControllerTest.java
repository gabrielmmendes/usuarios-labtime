package br.com.gabrielmmendes;

import java.util.List;

import br.com.gabrielmmendes.controller.UsuarioController;
import br.com.gabrielmmendes.model.Usuario;
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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
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

    @Test //teste de integração responsável por testar o objeto repository do Spring Data, ele está solicitando o repositório para todos os usuários e, em seguida, usando o Hamcrest para garantir que a lista de retorno seja maior ou igual a 0.
    public void testFindAll() {
        List<Usuario> usuario = repository.findAll();
        assertThat(usuario.size(), is(greaterThanOrEqualTo(0)));
    }
}
