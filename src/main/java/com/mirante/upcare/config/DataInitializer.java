// -------------------------------------Ideia não totalmente descartada-----------------------

// package com.mirante.upcare.config;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import com.mirante.upcare.models.Role;
// import com.mirante.upcare.models.enums.TipoUsuario;
// import com.mirante.upcare.repository.RoleRepository;

// @Component
// public class DataInitializer implements CommandLineRunner  {

//     private RoleRepository roleRepository;

//     public DataInitializer(RoleRepository roleRepository) {
//         this.roleRepository = roleRepository;
//     }

//     @Override
//     public void run(String... args) throws Exception {
//         // Para iniciar com a tabela role com esses tres registro;
//         for (TipoUsuario tipoUsuario : TipoUsuario.values()) {
//             criarRoleSeNaoExistir(tipoUsuario.name());
//         }
//     }

//     private void criarRoleSeNaoExistir(String nomeRole) {
//         boolean existe = roleRepository.findByNome(nomeRole).isPresent();
//         if (!existe) {
//             roleRepository.save(new Role(nomeRole));
//             System.out.println("Role criada: " + nomeRole);
//         }
//     }
    
// }
