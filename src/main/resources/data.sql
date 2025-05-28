
-- Estacao
INSERT INTO estacao (id, nome, latitude, longitude, endereco, link_grafana, status) VALUES
('e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Estação Central', -2.529, -44.301, 'Av. Principal, 100 - Centro',        'http://grafana.local/central', 'FUNCIONANDO'),
('f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Estação Norte',   -2.482, -44.231, 'Rua das Árvores, 45 - Bairro Norte', 'http://grafana.local/norte',   'DEFEITO'),
('a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Estação Leste',   -2.540, -44.220, 'Travessa Leste, 200 - Vila Leste',   'http://grafana.local/leste',   'MANUTENCAO'),
('ae2132d0-1b3f-4d13-90c9-02c4b4ffb095', 'Estação Sul',     -2.600, -44.350, 'Rua das Palmeiras, 789 - Sul',       'http://grafana.local/sul',     'STAND_BY'),
('2fbb0a17-c2ea-41fd-8a02-bdd82dc4c793', 'Estação Oeste',   -2.510, -44.380, 'Rua das Hortas, 654 - Oeste',        'http://grafana.local/oeste',   'STAND_BY');
      
-- -- Equipamentos da Estacao Central
-- INSERT INTO Equipamento (id, fk_estacao, marca, codigo, modelo, categoria, status, tipo) VALUES
-- ('0d982bc2-9e76-466d-899c-2e6d0429f30e', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'LG', 'ANT001', 'ANTENA_MOD1', 'TELEMETRICA', 'FUNCIONANDO', 'ANTENA'),
-- ('4cd837db-7876-4d3e-95a7-30c1b53eca5b', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'MarcaX', 'ANT003', 'ANTENA_MOD3', 'TELEMETRICA', 'FUNCIONANDO', 'ANTENA'),
-- ('93a2e942-cc12-443c-9058-73f92a4b7b49', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'MarcaX', 'AR_004', 'AR_CONDICIONADO_MOD1', 'REFRIGERACAO', 'FUNCIONANDO', 'AR_CONDICIONADO'),
-- ('14427b47-d2a5-460e-95f8-4bcd5d9679f4', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Intelbras', 'AR_006', 'AR_CONDICIONADO_MOD3', 'REFRIGERACAO', 'MANUTENCAO', 'AR_CONDICIONADO'),
-- ('b988b8e8-c276-4d0b-a5e7-27ef900de953', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Intelbras', 'CAB007', 'CABO_MOD1', 'ELETRICA', 'STAND_BY', 'CABO'),
-- ('a674b81c-11c9-41ad-b0ae-6b91083305a0', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'MarcaX', 'CAB009', 'CABO_MOD3', 'ELETRICA', 'DEFEITO', 'CABO'),
-- ('64b7ed7b-e61c-4590-ad62-eaeb5bcd2c8a', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Midea', 'COM010', 'COMBINADOR_MOD1', 'TELEMETRICA', 'FUNCIONANDO', 'COMBINADOR'),
-- ('d93c46e2-22c2-4512-a25b-165c42b6810a', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Siemens', 'COM011', 'COMBINADOR_MOD2', 'TELEMETRICA', 'DEFEITO', 'COMBINADOR'),
-- ('2d1db0a9-80ef-4858-a6c2-aa1bceb6c1dc', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'LG', 'DIS013', 'DISJUNTOR_MOD1', 'ELETRICA', 'DEFEITO', 'DISJUNTOR'),
-- ('65aecbc2-b6fc-47e5-b55f-3942c2078419', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'MarcaX', 'DIS014', 'DISJUNTOR_MOD2', 'ELETRICA', 'MANUTENCAO', 'DISJUNTOR'),
-- ('13b31b44-fae8-4465-9eac-d17633b88ce7', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'MarcaZ', 'DIS015', 'DISJUNTOR_MOD3', 'ELETRICA', 'STAND_BY', 'DISJUNTOR'),
-- ('e3c5a403-7e9a-475f-b843-7b848df75a67', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Intelbras', 'DPS017', 'DPS_MOD2', 'ELETRICA', 'STAND_BY', 'DPS'),
-- ('1ad4de0b-e1f2-4a56-9b3c-bc67fee61251', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Midea', 'DPS018', 'DPS_MOD3', 'ELETRICA', 'FUNCIONANDO', 'DPS'),
-- ('1274fec1-a7be-45e2-bf23-72845cd6bd8d', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Siemens', 'EXA020', 'EXAUSTOR_MOD2', 'REFRIGERACAO', 'STAND_BY', 'EXAUSTOR'),
-- ('a2735340-8b1f-4a14-804f-ed5265b3f26a', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Samsung', 'EXA021', 'EXAUSTOR_MOD3', 'REFRIGERACAO', 'STAND_BY', 'EXAUSTOR'),
-- ('37ec510a-88d6-4273-a726-3681c1406911', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Siemens', 'NOB022', 'NOBREAK_MOD1', 'ELETRICA', 'STAND_BY', 'NOBREAK'),
-- ('7e9bff60-124d-4706-946f-d681bc8e0198', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'MarcaZ', 'NOB024', 'NOBREAK_MOD3', 'ELETRICA', 'STAND_BY', 'NOBREAK'),
-- ('fbace6d4-54b5-4142-af8d-0ffe69991015', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'MarcaX', 'PAR025', 'PARABOLICA_MOD1', 'IRRADIACAO', 'STAND_BY', 'PARABOLICA'),
-- ('9d5f97a0-74c7-4675-ae39-0c53de0399ed', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'LG', 'PAR027', 'PARABOLICA_MOD3', 'IRRADIACAO', 'MANUTENCAO', 'PARABOLICA'),
-- ('5830a12e-4c08-4f21-8ece-56e45d12c32d', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Siemens', 'QUA028', 'QUADRO_MOD1', 'ELETRICA', 'FUNCIONANDO', 'QUADRO'),
-- ('01b56e9e-968a-4725-991c-5abc93c54bde', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Samsung', 'QUA029', 'QUADRO_MOD2', 'ELETRICA', 'FUNCIONANDO', 'QUADRO'),
-- ('75acb530-e55f-40e8-b1d1-90e2c084cb04', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'MarcaZ', 'REC031', 'RECEPTOR_MOD1', 'TELEMETRICA', 'MANUTENCAO', 'RECEPTOR'),
-- ('5084223c-a396-4447-80e0-682227da5b0b', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Samsung', 'REC032', 'RECEPTOR_MOD2', 'TELEMETRICA', 'STAND_BY', 'RECEPTOR'),
-- ('46650ae9-03ed-4c02-bff0-8b27d53dcc1a', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'MarcaY', 'SWI035', 'SWITCH_MOD2', 'TELEMETRICA', 'STAND_BY', 'SWITCH'),
-- ('ea49ab5e-323a-4152-8ea6-71e231764c03', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Intelbras', 'TEL037', 'TELEMETRIA_MOD1', 'TELEMETRICA', 'DEFEITO', 'TELEMETRIA'),
-- ('82329abf-79b1-4bc7-a56b-0ea82446a321', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'LG', 'TEL039', 'TELEMETRIA_MOD3', 'TELEMETRICA', 'STAND_BY', 'TELEMETRIA'),
-- ('9516bf85-2882-447b-9f92-912a4df480aa', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Samsung', 'TOR041', 'TORRE_MOD2', 'IRRADIACAO', 'STAND_BY', 'TORRE'),
-- ('18367118-4b98-4e67-bf7f-bb6019ee3336', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Midea', 'TRA043', 'TRANSMISSOR_MOD1', 'TELEMETRICA', 'FUNCIONANDO', 'TRANSMISSOR'),
-- ('65f96ee0-606d-417a-b5c7-6333deaafbd6', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Siemens', 'TRA045', 'TRANSMISSOR_MOD3', 'TELEMETRICA', 'FUNCIONANDO', 'TRANSMISSOR');

-- -- Equipamentos da Estacao Norte
-- INSERT INTO Equipamento (id, fk_estacao, marca, codigo, modelo, categoria, status, tipo) VALUES
-- ('78b2018d-f4d5-473e-9b99-1f1f48079d69', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Intelbras', 'ANT002', 'ANTENA_MOD2', 'TELEMETRICA', 'FUNCIONANDO', 'ANTENA'),
-- ('a99ce198-268b-4196-bc54-0876e4f6f237', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Intelbras', 'ANT003', 'ANTENA_MOD3', 'TELEMETRICA', 'DEFEITO', 'ANTENA'),
-- ('5761cace-b4dc-40ac-b36f-06d48b25fb2d', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Midea', 'AR_004', 'AR_CONDICIONADO_MOD1', 'REFRIGERACAO', 'MANUTENCAO', 'AR_CONDICIONADO'),
-- ('acbaba1c-a62d-40ef-a264-45dff347299e', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Samsung', 'AR_006', 'AR_CONDICIONADO_MOD3', 'REFRIGERACAO', 'STAND_BY', 'AR_CONDICIONADO'),
-- ('ae928e4f-193c-4a7d-808f-4e9f9f8af888', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'MarcaZ', 'CAB007', 'CABO_MOD1', 'ELETRICA', 'DEFEITO', 'CABO'),
-- ('80ac6984-3907-42e0-88a1-3d789a13686d', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'LG', 'CAB009', 'CABO_MOD3', 'ELETRICA', 'MANUTENCAO', 'CABO'),
-- ('3ed9f29a-aebe-448c-a45f-4285d0141a8d', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Intelbras', 'COM010', 'COMBINADOR_MOD1', 'TELEMETRICA', 'FUNCIONANDO', 'COMBINADOR'),
-- ('6ea97d56-b42a-4a87-9954-1ae36b804bf5', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Midea', 'DIS013', 'DISJUNTOR_MOD1', 'ELETRICA', 'DEFEITO', 'DISJUNTOR'),
-- ('df320d86-89a8-46a3-b250-3733b5a88fbf', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'MarcaZ', 'DIS015', 'DISJUNTOR_MOD3', 'ELETRICA', 'DEFEITO', 'DISJUNTOR'),
-- ('08426252-9b40-41f3-bdae-ad07051f707d', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Samsung', 'DPS018', 'DPS_MOD3', 'ELETRICA', 'MANUTENCAO', 'DPS'),
-- ('adf970ce-cc2a-4fd6-88f5-eaab6dbb23b1', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Intelbras', 'EXA020', 'EXAUSTOR_MOD2', 'REFRIGERACAO', 'FUNCIONANDO', 'EXAUSTOR'),
-- ('094fa69c-a4a4-4ba2-a71f-8b4b08fb230d', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Siemens', 'NOB022', 'NOBREAK_MOD1', 'ELETRICA', 'STAND_BY', 'NOBREAK'),
-- ('9a8d1c73-3650-4ac6-bd53-b8a47b0d54ef', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'MarcaY', 'PAR025', 'PARABOLICA_MOD1', 'IRRADIACAO', 'STAND_BY', 'PARABOLICA'),
-- ('2eea6bb7-44fa-4104-a985-9de32156ca9c', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Samsung', 'PAR027', 'PARABOLICA_MOD3', 'IRRADIACAO', 'FUNCIONANDO', 'PARABOLICA'),
-- ('2affb5e9-fdbe-4e8b-b322-61bc288cd2c4', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Midea', 'QUA029', 'QUADRO_MOD2', 'ELETRICA', 'MANUTENCAO', 'QUADRO'),
-- ('30fbe986-d64d-4a5c-9a80-a855f8efd106', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'MarcaY', 'QUA030', 'QUADRO_MOD3', 'ELETRICA', 'MANUTENCAO', 'QUADRO'),
-- ('576b2527-9a81-4073-8b57-6cad43651651', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'MarcaY', 'REC032', 'RECEPTOR_MOD2', 'TELEMETRICA', 'FUNCIONANDO', 'RECEPTOR'),
-- ('6ead95a6-2ad3-4f6d-ba19-1bc49d4b5f5c', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'MarcaX', 'SWI034', 'SWITCH_MOD1', 'TELEMETRICA', 'MANUTENCAO', 'SWITCH'),
-- ('957f1bd3-fa8c-4e0d-af95-50bc29ff299c', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'MarcaX', 'SWI036', 'SWITCH_MOD3', 'TELEMETRICA', 'STAND_BY', 'SWITCH'),
-- ('b5001cee-f49e-4627-8125-1f8a4af30d0a', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Samsung', 'TEL037', 'TELEMETRIA_MOD1', 'TELEMETRICA', 'DEFEITO', 'TELEMETRIA'),
-- ('9a5065b1-b914-4225-9e07-901a334822b6', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'MarcaZ', 'TOR040', 'TORRE_MOD1', 'IRRADIACAO', 'MANUTENCAO', 'TORRE'),
-- ('537d6741-c59a-4330-ba40-ed8e00fe51dc', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Siemens', 'TRA044', 'TRANSMISSOR_MOD2', 'TELEMETRICA', 'MANUTENCAO', 'TRANSMISSOR'),
-- ('cf389fb1-0583-4535-bd89-4e9c6bcc6685', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Midea', 'TRA045', 'TRANSMISSOR_MOD3', 'TELEMETRICA', 'FUNCIONANDO', 'TRANSMISSOR');

-- -- Equipamentos da Estacao Leste
-- INSERT INTO Equipamento (id, fk_estacao, marca, codigo, modelo, categoria, status, tipo) VALUES
-- ('7f6c254c-a316-4032-a8e8-78a1d7adf533', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'LG', 'ANT001', 'ANTENA_MOD1', 'TELEMETRICA', 'MANUTENCAO', 'ANTENA'),
-- ('822bca4a-50c9-4688-b629-ea5092bd76be', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'MarcaX', 'ANT003', 'ANTENA_MOD3', 'TELEMETRICA', 'MANUTENCAO', 'ANTENA'),
-- ('a4134fca-3bac-4085-9b44-0fecbb68d006', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Samsung', 'AR_006', 'AR_CONDICIONADO_MOD3', 'REFRIGERACAO', 'STAND_BY', 'AR_CONDICIONADO'),
-- ('01c3a37f-936d-44b1-927e-0fc46a77c7ec', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'MarcaZ', 'CAB007', 'CABO_MOD1', 'ELETRICA', 'STAND_BY', 'CABO'),
-- ('3b99463c-750f-4807-af84-23babb1ee016', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'MarcaX', 'COM010', 'COMBINADOR_MOD1', 'TELEMETRICA', 'MANUTENCAO', 'COMBINADOR'),
-- ('275bb3fe-a5c6-486c-9a83-77efabc3408a', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Intelbras', 'COM012', 'COMBINADOR_MOD3', 'TELEMETRICA', 'FUNCIONANDO', 'COMBINADOR'),
-- ('0b9fc69c-7b72-438d-af93-e2d9cfff04b0', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'LG', 'DIS013', 'DISJUNTOR_MOD1', 'ELETRICA', 'STAND_BY', 'DISJUNTOR'),
-- ('79a11a3f-b696-46f0-bf37-3314ee9a1409', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'MarcaX', 'DPS016', 'DPS_MOD1', 'ELETRICA', 'FUNCIONANDO', 'DPS'),
-- ('5f74f2c9-20ff-42ba-8f24-715f5ca3498e', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'LG', 'EXA019', 'EXAUSTOR_MOD1', 'REFRIGERACAO', 'FUNCIONANDO', 'EXAUSTOR'),
-- ('3a6b601e-d68d-4520-8254-5ef34ed3cd61', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Midea', 'EXA021', 'EXAUSTOR_MOD3', 'REFRIGERACAO', 'STAND_BY', 'EXAUSTOR'),
-- ('bbfbe381-f9b2-4ab0-82b2-43b330a03579', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Midea', 'NOB023', 'NOBREAK_MOD2', 'ELETRICA', 'STAND_BY', 'NOBREAK'),
-- ('bd305e00-8a62-4b99-907d-87b21b7baf6b', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'MarcaZ', 'NOB024', 'NOBREAK_MOD3', 'ELETRICA', 'MANUTENCAO', 'NOBREAK'),
-- ('12d673cb-3f94-4f36-bc41-416fa6c6a281', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'MarcaY', 'PAR025', 'PARABOLICA_MOD1', 'IRRADIACAO', 'DEFEITO', 'PARABOLICA'),
-- ('e1b0fe56-f66b-4655-bb3e-b20db7420c50', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'LG', 'PAR026', 'PARABOLICA_MOD2', 'IRRADIACAO', 'STAND_BY', 'PARABOLICA'),
-- ('f752e707-1199-4f18-bb02-ff7c842d8b46', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'MarcaZ', 'PAR027', 'PARABOLICA_MOD3', 'IRRADIACAO', 'FUNCIONANDO', 'PARABOLICA'),
-- ('d7ee23a5-ea0f-4447-89f7-847f8ecad301', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'LG', 'QUA029', 'QUADRO_MOD2', 'ELETRICA', 'FUNCIONANDO', 'QUADRO'),
-- ('6c144c46-27fc-4f8e-81ab-f079ca2a474c', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Intelbras', 'QUA030', 'QUADRO_MOD3', 'ELETRICA', 'MANUTENCAO', 'QUADRO'),
-- ('59615ab0-c31a-46a6-9e60-a0bd6385d9fb', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Siemens', 'REC031', 'RECEPTOR_MOD1', 'TELEMETRICA', 'STAND_BY', 'RECEPTOR'),
-- ('67946fc0-d701-4be4-9da3-ee51d17e0775', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Midea', 'REC033', 'RECEPTOR_MOD3', 'TELEMETRICA', 'DEFEITO', 'RECEPTOR'),
-- ('d381a08b-98a8-4b91-ad82-8453d21d9f2c', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'MarcaX', 'SWI036', 'SWITCH_MOD3', 'TELEMETRICA', 'FUNCIONANDO', 'SWITCH'),
-- ('de96e873-bff2-4cb8-8ee6-9c2efd24e427', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Midea', 'TEL038', 'TELEMETRIA_MOD2', 'TELEMETRICA', 'STAND_BY', 'TELEMETRIA'),
-- ('346892cd-9017-4520-b838-737576ce1053', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Siemens', 'TEL039', 'TELEMETRIA_MOD3', 'TELEMETRICA', 'FUNCIONANDO', 'TELEMETRIA'),
-- ('35958f23-51de-40f8-8413-55a0037207bd', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'MarcaX', 'TOR040', 'TORRE_MOD1', 'IRRADIACAO', 'FUNCIONANDO', 'TORRE'),
-- ('833a4004-706c-455f-9716-63b7890fbe16', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'MarcaY', 'TOR042', 'TORRE_MOD3', 'IRRADIACAO', 'STAND_BY', 'TORRE'),
-- ('72c39c03-7059-444e-988c-c2322f919c9b', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'MarcaY', 'TRA045', 'TRANSMISSOR_MOD3', 'TELEMETRICA', 'FUNCIONANDO', 'TRANSMISSOR');



-- INSERT INTO ar_condicionado (id, fk_equipamento, potencia, tensao) VALUES
-- ('f7efab7a-a8b1-41af-8f3d-c92a9bec5ac6', '93a2e942-cc12-443c-9058-73f92a4b7b49', 18000.0, 220.0),
-- ('330a01fe-a4f1-47c6-a74a-bd99c55b6bc4', '14427b47-d2a5-460e-95f8-4bcd5d9679f4', 12000.0, 220.0),
-- ('c8f8428b-64bb-46e0-8460-c29f660fe0b2', '5761cace-b4dc-40ac-b36f-06d48b25fb2d', 12000.0, 220.0),
-- ('3b324e44-161d-48a5-81af-0677eddc4699', 'acbaba1c-a62d-40ef-a264-45dff347299e', 18000.0, 220.0),
-- ('2e1973c4-07ef-4686-9ec7-7a2b2b1efc5f', 'a4134fca-3bac-4085-9b44-0fecbb68d006', 15000.0, 220.0);

-- INSERT INTO cabo (id, fk_equipamento, tipo, tamanho) VALUES
-- ('373055d4-7732-46e2-b2b5-ce756c464c36', 'b988b8e8-c276-4d0b-a5e7-27ef900de953', 'C_7_8', 25.0),
-- ('70311c26-3fea-4af4-87b3-2d917d808911', 'a674b81c-11c9-41ad-b0ae-6b91083305a0', 'C_15_8', 10.0),
-- ('18370174-5e84-4a48-976d-da666c02c61d', 'ae928e4f-193c-4a7d-808f-4e9f9f8af888', 'C_7_8', 10.5),
-- ('4d825b0d-1563-42f7-8f00-ac194268404a', '80ac6984-3907-42e0-88a1-3d789a13686d', 'C_15_8', 7.2),
-- ('d4aaf7db-e63b-4d87-bc3b-1412f592a6c2', '01c3a37f-936d-44b1-927e-0fc46a77c7ec', 'C_7_8', 12.0);


-- INSERT INTO combinador (id, fk_equipamento) VALUES
-- ('7c870c2e-2b0b-46a6-912f-5df144d25a00', '64b7ed7b-e61c-4590-ad62-eaeb5bcd2c8a'),
-- ('0fba687e-42ae-4d04-8705-ff8699c565f1', 'd93c46e2-22c2-4512-a25b-165c42b6810a'),
-- ('0bc333e9-92d6-4284-86b9-d17dd7864005', '3ed9f29a-aebe-448c-a45f-4285d0141a8d'),
-- ('f5f8b425-5e6e-4ab1-9a33-869d3bf6c96f', '3b99463c-750f-4807-af84-23babb1ee016'),
-- ('c63bc76c-ff47-42d9-95e1-3a7f1aeb37d7', '275bb3fe-a5c6-486c-9a83-77efabc3408a');

-- INSERT INTO exaustor (id, fk_equipamento) VALUES
-- ('db5bb213-8577-421d-9198-89fb4c8ec343', '1274fec1-a7be-45e2-bf23-72845cd6bd8d'),
-- ('79df5d2a-3085-4c00-985a-427140b655bb', 'a2735340-8b1f-4a14-804f-ed5265b3f26a'),
-- ('38c54cd9-1307-4f61-9a8a-45cbe9a9f09e', 'adf970ce-cc2a-4fd6-88f5-eaab6dbb23b1'),
-- ('c680aa6c-c869-43f0-b032-9eb2f4958f46', '5f74f2c9-20ff-42ba-8f24-715f5ca3498e'),
-- ('55374d82-5a30-4b49-80ac-5c4c146309eb', '3a6b601e-d68d-4520-8254-5ef34ed3cd61');

-- INSERT INTO torre (id, fk_equipamento, tipo, aterrada, altura) VALUES
-- ('eb5d5197-3950-4712-94c2-57eb727fbca4', '9516bf85-2882-447b-9f92-912a4df480aa', 'AUTOPORTANTE', TRUE, 30.5),
-- ('94f82698-b8c1-440e-a99c-6e68dafb8da0', '9a5065b1-b914-4225-9e07-901a334822b6', 'ESTAIADA', true, 30.0),
-- ('6d1a87ac-6e4d-4f97-9b5f-6771c5d3f79a', '35958f23-51de-40f8-8413-55a0037207bd', 'AUTOPORTANTE', true, 28.0),
-- ('adf034b3-1965-41b7-8e5b-4d7a6227491b', '833a4004-706c-455f-9716-63b7890fbe16', 'ESTAIADA', false, 32.5);

-- INSERT INTO telemetria (id, fk_equipamento) VALUES
-- ('ef56f789-348d-44ac-97bd-84aa8bdc837a', '18367118-4b98-4e67-bf7f-bb6019ee3336'),
-- ('b0dc4c5e-cadd-4932-85b9-78f8ffce3783', '65f96ee0-606d-417a-b5c7-6333deaafbd6'),
-- ('6efbfd5c-6014-4884-bf15-a1db165a01ff', 'b5001cee-f49e-4627-8125-1f8a4af30d0a'),
-- ('f5e9b39c-9d92-4dbb-9b27-ccfd9ee17d6f', 'de96e873-bff2-4cb8-8ee6-9c2efd24e427'),
-- ('e9f142e7-59af-49c1-a6e2-8388f0c2db5d', '346892cd-9017-4520-b838-737576ce1053');

-- INSERT INTO transmissor (id, fk_equipamento, programado, canal_fisico, canal_virtual, acoplador_um, acoplador_dois) VALUES
-- ('18367118-4b98-4e67-bf7f-bb6019ee3336', '18367118-4b98-4e67-bf7f-bb6019ee3336', 'SIM', 21.0, 7.1, 0.85, 0.90),
-- ('65f96ee0-606d-417a-b5c7-6333deaafbd6', '65f96ee0-606d-417a-b5c7-6333deaafbd6', 'SIM', 33.0, 9.3, 0.80, 0.88),
-- ('537d6741-c59a-4330-ba40-ed8e00fe51dc', '537d6741-c59a-4330-ba40-ed8e00fe51dc', 'SIM', 28.0, 8.2, 0.81, 0.87),
-- ('cf389fb1-0583-4535-bd89-4e9c6bcc6685', 'cf389fb1-0583-4535-bd89-4e9c6bcc6685', 'SIM', 35.0, 11.5, 0.93, 0.89),
-- ('72c39c03-7059-444e-988c-c2322f919c9b', '72c39c03-7059-444e-988c-c2322f919c9b', 'SIM', 26.0, 9.5, 0.88, 0.91);

-- INSERT INTO antena (id, fk_equipamento, fk_transmissor, gain, tipo, posicao, vr) VALUES
-- ('3bdf1e3f-ffed-4140-8919-bf7302a42d19', '0d982bc2-9e76-466d-899c-2e6d0429f30e', '18367118-4b98-4e67-bf7f-bb6019ee3336', '15dBi', 'OMNIDIRECIONAL', 'TOPO', 0.87),
-- ('6b67c084-9aa7-4e1a-a8e9-0e4fa733f7f0', '4cd837db-7876-4d3e-95a7-30c1b53eca5b', '65f96ee0-606d-417a-b5c7-6333deaafbd6', '18dBi', 'DIRETIVA', 'LATERAL', 1.12),
-- ('e3cb65f0-5c34-4c7c-b2e1-0a1a6d23531d', '78b2018d-f4d5-473e-9b99-1f1f48079d69', 'cf389fb1-0583-4535-bd89-4e9c6bcc6685', '16dBi', 'OMNIDIRECIONAL', 'TOPO', 0.92),
-- ('fa164e00-0fc7-4c90-b9e3-34670c63ef15', 'a99ce198-268b-4196-bc54-0876e4f6f237', '537d6741-c59a-4330-ba40-ed8e00fe51dc', '14dBi', 'DIRETIVA', 'LATERAL', 1.05),
-- ('bfd252db-69d6-4b4b-a4cd-c92b02d4a98c', '7f6c254c-a316-4032-a8e8-78a1d7adf533', '72c39c03-7059-444e-988c-c2322f919c9b', '12dBi', 'OMNIDIRECIONAL', 'TOPO', 0.90),
-- ('b2f08ec0-7e25-4260-b86a-137fdf74db71', '822bca4a-50c9-4688-b629-ea5092bd76be', '72c39c03-7059-444e-988c-c2322f919c9b', '15dBi', 'DIRETIVA', 'LATERAL', 1.00);

-- INSERT INTO parabolica (id, fk_equipamento, diametro, satelite) VALUES
-- ('d59389c2-ec38-429c-8b01-d0f8a40c360b', 'fbace6d4-54b5-4142-af8d-0ffe69991015', 2.4, 'StarOne C2'),
-- ('9e3c7c2e-2373-4a2b-b355-2cc6a24b6ae7', '9d5f97a0-74c7-4675-ae39-0c53de0399ed', 3.1, 'Amazonas 61W'),
-- ('e3a4c19b-d62f-4a19-a0ae-fcdaed647627', '9a8d1c73-3650-4ac6-bd53-b8a47b0d54ef', 2.5, 'StarOne D2'),
-- ('4c0efb2b-3cc4-48e7-bba7-c4e8c3390d43', '2eea6bb7-44fa-4104-a985-9de32156ca9c', 3.0, 'Hispasat 30W'),
-- ('d4a7322e-25c4-44ec-9899-5fcfc27b2b16', '12d673cb-3f94-4f36-bc41-416fa6c6a281', 2.2, 'StarOne C3'),
-- ('5144031e-863e-4306-b25e-85c74fc241a0', 'e1b0fe56-f66b-4655-bb3e-b20db7420c50', 2.8, 'Hispasat 30W'),
-- ('5b524f2e-d2f4-42c6-aaf9-5c91ec918e91', 'f752e707-1199-4f18-bb02-ff7c842d8b46', 3.1, 'Amazonas 61W');

-- INSERT INTO receptor (id, fk_equipamento, fk_parabolica, fk_transmissor, canal, frequencia, symbol_rate) VALUES
-- ('7095c61a-c80f-44bb-8006-dde7714053f3', '75acb530-e55f-40e8-b1d1-90e2c084cb04', 'd59389c2-ec38-429c-8b01-d0f8a40c360b', '18367118-4b98-4e67-bf7f-bb6019ee3336', 5.2, 457, 27500),
-- ('ac84511a-5b14-4d30-9152-f6cfa5f1dcbe', '5084223c-a396-4447-80e0-682227da5b0b', '9e3c7c2e-2373-4a2b-b355-2cc6a24b6ae7', '65f96ee0-606d-417a-b5c7-6333deaafbd6', 7.1, 519, 30000),
-- ('79fded8f-5df1-4f08-a248-1aa7cf5aa361', '576b2527-9a81-4073-8b57-6cad43651651', 'e3a4c19b-d62f-4a19-a0ae-fcdaed647627', 'cf389fb1-0583-4535-bd89-4e9c6bcc6685', 6.7, 478, 29500),
-- ('fba68d8c-fd25-4d49-a9cd-2b7b6d588f09', '59615ab0-c31a-46a6-9e60-a0bd6385d9fb', '5144031e-863e-4306-b25e-85c74fc241a0', '72c39c03-7059-444e-988c-c2322f919c9b', 7.3, 490, 27500),
-- ('d98de317-dac1-4b4d-aeff-8880a896cc23', '67946fc0-d701-4be4-9da3-ee51d17e0775', '5b524f2e-d2f4-42c6-aaf9-5c91ec918e91', '72c39c03-7059-444e-988c-c2322f919c9b', 5.8, 462, 28800);

-- INSERT INTO quadro (id, fk_equipamento) VALUES
-- ('5830a12e-4c08-4f21-8ece-56e45d12c32d', '5830a12e-4c08-4f21-8ece-56e45d12c32d'),
-- ('01b56e9e-968a-4725-991c-5abc93c54bde', '01b56e9e-968a-4725-991c-5abc93c54bde'),
-- ('e1411e58-9761-49f0-aac1-6e12ccb68a57', '2affb5e9-fdbe-4e8b-b322-61bc288cd2c4'),
-- ('5d0a9a33-276e-4acb-850b-5be5cfdf7f58', '30fbe986-d64d-4a5c-9a80-a855f8efd106'),
-- ('d7ee23a5-ea0f-4447-89f7-847f8ecad301', 'd7ee23a5-ea0f-4447-89f7-847f8ecad301'),
-- ('6c144c46-27fc-4f8e-81ab-f079ca2a474c', '6c144c46-27fc-4f8e-81ab-f079ca2a474c');

-- INSERT INTO disjuntor (id, fk_equipamento, fk_quadro, corrente_maxima) VALUES
-- ('abd67641-fc8d-4635-9728-23367edbe229', '2d1db0a9-80ef-4858-a6c2-aa1bceb6c1dc', '5830a12e-4c08-4f21-8ece-56e45d12c32d', 32.0),
-- ('34ff7676-4f00-44aa-a5f9-4377f825e067', '65aecbc2-b6fc-47e5-b55f-3942c2078419', '01b56e9e-968a-4725-991c-5abc93c54bde', 40.0),
-- ('5f5e48a6-23d5-4aa0-abb1-c78df1f1c4a7', '13b31b44-fae8-4465-9eac-d17633b88ce7', '5830a12e-4c08-4f21-8ece-56e45d12c32d', 50.0),
-- ('03aa294c-52db-462b-a13a-e2585ff2ed29', '6ea97d56-b42a-4a87-9954-1ae36b804bf5', 'e1411e58-9761-49f0-aac1-6e12ccb68a57', 10.7),
-- ('462e063c-1f9a-4162-938a-6f67219631de', 'df320d86-89a8-46a3-b250-3733b5a88fbf', '5d0a9a33-276e-4acb-850b-5be5cfdf7f58', 10.1),
-- ('eb3f65c9-8b74-4b49-9d8f-2a9057cbd9f5', '0b9fc69c-7b72-438d-af93-e2d9cfff04b0', 'd7ee23a5-ea0f-4447-89f7-847f8ecad301', 10.3);

-- INSERT INTO dps (id, fk_equipamento, fk_quadro, classe_dps) VALUES
-- ('43dba32c-fb94-4111-a804-fbdb72d93071', 'e3c5a403-7e9a-475f-b843-7b848df75a67', '01b56e9e-968a-4725-991c-5abc93c54bde', 'D_1'),
-- ('aef909c2-3b47-49b6-94b8-22eeb7e11db8', '1ad4de0b-e1f2-4a56-9b3c-bc67fee61251', '5830a12e-4c08-4f21-8ece-56e45d12c32d', 'D_2'),
-- ('007e7ce0-29d8-43c0-9609-95025afe39f7', '08426252-9b40-41f3-bdae-ad07051f707d', 'e1411e58-9761-49f0-aac1-6e12ccb68a57', 'D_2'),
-- ('be3de8ef-6a63-43e4-a1d5-6b1a7d9f3ae3', '79a11a3f-b696-46f0-bf37-3314ee9a1409', 'd7ee23a5-ea0f-4447-89f7-847f8ecad301', 'D_1');

-- INSERT INTO nobreak (id, fk_equipamento, fk_quadro, tensao_entrada, tensao_saida) VALUES
-- ('3a7f45fc-78a4-428b-afc6-134d7ca55aa3', '37ec510a-88d6-4273-a726-3681c1406911', '5830a12e-4c08-4f21-8ece-56e45d12c32d', 220, 120),
-- ('cab69b07-dc2f-4ef9-86bb-6daae401a919', '7e9bff60-124d-4706-946f-d681bc8e0198', '01b56e9e-968a-4725-991c-5abc93c54bde', 220, 220),
-- ('c9c9d703-f83e-4fb8-b776-fadd2fff966a', '094fa69c-a4a4-4ba2-a71f-8b4b08fb230d', '5d0a9a33-276e-4acb-850b-5be5cfdf7f58', 220, 110),
-- ('62de9a7e-d6bc-4fe2-9e0e-cc3ff708b8f8', 'bbfbe381-f9b2-4ab0-82b2-43b330a03579', 'd7ee23a5-ea0f-4447-89f7-847f8ecad301', 220, 110),
-- ('cb30b15d-c43e-44d7-b9de-2b89933872c6', 'bd305e00-8a62-4b99-907d-87b21b7baf6b', '6c144c46-27fc-4f8e-81ab-f079ca2a474c', 220, 110);

-- INSERT INTO switch (id, fk_equipamento, fk_quadro, qtd_portas) VALUES
-- ('9da771b2-f535-424b-88ff-a6c50feceb70', '46650ae9-03ed-4c02-bff0-8b27d53dcc1a', '5830a12e-4c08-4f21-8ece-56e45d12c32d', 24),
-- ('f3a3933f-5076-4fb7-a354-378b438c6ecd', '6ead95a6-2ad3-4f6d-ba19-1bc49d4b5f5c', 'e1411e58-9761-49f0-aac1-6e12ccb68a57', 32),
-- ('1db980bd-2faa-4465-b4f4-38410da2a264', '957f1bd3-fa8c-4e0d-af95-50bc29ff299c', '5d0a9a33-276e-4acb-850b-5be5cfdf7f58', 8),
-- ('f9272d17-c826-4204-bb26-71a71a62286b', 'd381a08b-98a8-4b91-ad82-8453d21d9f2c', '6c144c46-27fc-4f8e-81ab-f079ca2a474c', 16);
