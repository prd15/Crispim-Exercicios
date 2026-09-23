package com.finan.orcamento.controller;

import com.finan.orcamento.model.OrcamentoModel;
import com.finan.orcamento.model.enums.IcmsEstados;
import com.finan.orcamento.service.OrcamentoService;
import com.finan.orcamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/orcamentos")
public class OrcamentoController {
    @Autowired
    private OrcamentoService orcamentoService;
    // Precisamos do UsuarioService aqui para pesquisar o usuário dono do orçamento
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String getOrcamentoPage(Model model){
        model.addAttribute("newOrcamento", new OrcamentoModel());
        model.addAttribute("orcamentos", orcamentoService.buscarCadastro());
        model.addAttribute("estados", IcmsEstados.values());
        return "orcamentoPage";
    }

    @PostMapping
    public String cadastraOrcamento(@ModelAttribute("newOrcamento") OrcamentoModel orcamentoModel,
                                    @RequestParam(name="idUsuario", required=false) Long idUsuario){
        // O id vem do input hidden que o JavaScript preencheu ao clicar no nome pesquisado
        if (idUsuario != null) {
            orcamentoModel.setUsuario(usuarioService.buscaId(idUsuario));
        }
        orcamentoService.cadastrarOrcamento(orcamentoModel);
        return "redirect:/orcamentos";
    }

    @PostMapping(path="/delete/{id}")
    public String deletaOrcamento(@PathVariable Long id){
        orcamentoService.deletaOrcamento(id);
        return "redirect:/orcamentos";
    }
}
