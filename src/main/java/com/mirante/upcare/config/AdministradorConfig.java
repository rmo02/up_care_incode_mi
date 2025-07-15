package com.mirante.upcare.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.mirante.upcare.models.Empresa;
import com.mirante.upcare.models.Usuario;
import com.mirante.upcare.repository.EmpresaRepository;
import com.mirante.upcare.repository.RoleRepository;
import com.mirante.upcare.repository.UsuarioRepository;

@Configuration
public class AdministradorConfig implements CommandLineRunner {
    
    private RoleRepository roleRepository;
    private UsuarioRepository usuarioRepository;
    private EmpresaRepository empresaRepository;
    private BCryptPasswordEncoder passwordEncoder;
    
    public AdministradorConfig(RoleRepository roleRepository, UsuarioRepository usuarioRepository, EmpresaRepository empresaRepository, BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.usuarioRepository = usuarioRepository;
        this.empresaRepository = empresaRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    @Transactional
    public void run(String... args) throws Exception {
       
        var roleAdmin = roleRepository.findByNome("ADMIN").orElseThrow(() -> new RuntimeException("Role ADMIN não encontrada"));
        var usuarioAdmin = usuarioRepository.findByNome("ADMIN");
    
        usuarioAdmin.ifPresentOrElse(
            user -> {
                System.out.println("admin já existe");
            },
            () -> {
                Empresa empresa = new Empresa();
                empresa.setNome("TesteInterprise");
                empresa.setContato("00000000");
                empresa = empresaRepository.save(empresa);
                // Criando usuario temporario para acessar a aplicação
                var usuario = new Usuario();
                usuario.setNome("adminTeste");
                usuario.setEmail("admin@admin.com");
                usuario.setSenha(passwordEncoder.encode("40229822"));
                usuario.setContato("00000000");
                usuario.setEmpresa(empresa);
                usuario.setRoles(Set.of(roleAdmin));
                usuarioRepository.save(usuario);
                System.out.println("admin criado com sucesso");
            }
        );
    }   
    

}
