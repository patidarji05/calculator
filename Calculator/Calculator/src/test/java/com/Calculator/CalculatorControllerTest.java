package com.Calculator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

  @Autowired
  private MockMvc mockMvc;
  


@Test
  public void addTest() throws Exception {
    mockMvc.perform(get("/add/10/20"))
      .andExpect(status().isOk())
      .andExpect(content().string("30.0"));
  }
  
  @Test
  public void negatvieAddTest() throws Exception {
    mockMvc.perform(get("/add/ten/twenty"))
      .andExpect(status().isBadRequest());
  }
  
  @Test
  public void subTest() throws Exception {
    mockMvc.perform(get("/sub/50/20"))
      .andExpect(status().isOk())
      .andExpect(content().string("30.0"));
  }
  
  @Test
  public void negatvieSubTest() throws Exception {
    mockMvc.perform(get("/sub/fifty/twenty"))
      .andExpect(status().isBadRequest());
  }
  
  @Test
  public void mulTest() throws Exception {
    mockMvc.perform(get("/mul/8/6"))
      .andExpect(status().isOk())
      .andExpect(content().string("48.0"));
  }
  
  @Test
  public void negatvieMulTest() throws Exception {
    mockMvc.perform(get("/mul/fifty/8"))
      .andExpect(status().isBadRequest());
  }
  
  @Test
  public void divTest() throws Exception {
    mockMvc.perform(get("/div/25/5"))
      .andExpect(status().isOk())
      .andExpect(content().string("5.0"));
  }
  
 
  
  @Test
  public void negatvieDivTest() throws Exception {
    mockMvc.perform(get("/div/10/twenty"))
      .andExpect(status().isBadRequest());
  }
}

