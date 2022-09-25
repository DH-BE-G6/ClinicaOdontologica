package com.digitalhouse.clinicaodontologicag6.controller;

import com.digitalhouse.clinicaodontologicag6.entity.dto.DentistaDTO;
import com.digitalhouse.clinicaodontologicag6.entity.dto.PacienteDTO;
import com.digitalhouse.clinicaodontologicag6.enums.UserRoles;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.digitalhouse.clinicaodontologicag6.utils.ClinicaOdontologicaUtils.asJsonString;
import static com.digitalhouse.clinicaodontologicag6.utils.ClinicaOdontologicaUtils.objectFromString;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "Batata test", password = "test", roles = "ADMIN")
    void create() throws Exception{
        //=> Apenas admin pode criar paciente ok
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNome("Batata");
        pacienteDTO.setSobrenome("paciente testes");
        pacienteDTO.setUsername("Batata test");
        pacienteDTO.setPassword("test");
        pacienteDTO.setRg("00000001");
        pacienteDTO.setLogradouro("Rua dos QA");
        pacienteDTO.setNumero("001");
        pacienteDTO.setComplemento("Apt NaN");
        pacienteDTO.setBairro("Socorro");
        pacienteDTO.setCidade("Pesado dos dev");
        pacienteDTO.setEstado("QA");
        pacienteDTO.setCep("00000-001");
        pacienteDTO.setUserRoles(UserRoles.ROLE_USER);

        mockMvc.perform(MockMvcRequestBuilders.post("/paciente/cadastrar")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(pacienteDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @WithMockUser(username = "Batata test", password = "test", roles = "ADMIN")
    void getById() throws Exception {
        //=> criar um novo paciente para puxar ele obs: Não ficar dependendo de outro teste(boas praticas)
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNome("Batata");
        pacienteDTO.setSobrenome("paciente testes");
        pacienteDTO.setUsername("Batata test");
        pacienteDTO.setPassword("test");
        pacienteDTO.setRg("02020202");
        pacienteDTO.setLogradouro("Rua dos QA");
        pacienteDTO.setNumero("001");
        pacienteDTO.setComplemento("Apt NaN");
        pacienteDTO.setBairro("Socorro");
        pacienteDTO.setCidade("Pesado dos dev");
        pacienteDTO.setEstado("QA");
        pacienteDTO.setCep("00000-001");
        pacienteDTO.setUserRoles(UserRoles.ROLE_USER);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/paciente/cadastrar")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(pacienteDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        //=> Pego o paciente cadastrado, obs: pegou o id
        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);

        //=> Agora sim fazer o getById
        mockMvc.perform(MockMvcRequestBuilders.get("/paciente/buscar?id={id}", pacienteDTO.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getByNome() {
    }

    @Test
    void getByCidade() {
    }

    @Test
    void getByRg() {
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void createAuthenticationToken() {
    }
}