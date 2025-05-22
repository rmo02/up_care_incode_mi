

INSERT INTO estacao (id, nome, latitude, longitude, endereco, link_grafana, status) VALUES
('e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Estação Central', -2.529, -44.301, 'Av. Principal, 100 - Centro', 'http://grafana.local/central', 'FUNCIONANDO'),
('f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Estação Norte', -2.482, -44.231, 'Rua das Árvores, 45 - Bairro Norte', 'http://grafana.local/norte', 'STAND_BY'),
('a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Estação Leste', -2.540, -44.220, 'Travessa Leste, 200 - Vila Leste', 'http://grafana.local/leste', 'MANUTENCAO');



-- Equipamentos da Estação Central
INSERT INTO equipamento (id, fk_estacao, marca, codigo, modelo, categoria, status, tipo) VALUES
('87815e08-0ff5-45cf-a596-79d430983f58', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Ubiquiti', 'EQ-CEN-001', 'NanoBeam M5', 'TELEMETRICA', 'FUNCIONANDO', 'CABO'),
('4680e683-1708-42c7-8b0d-c70779137bf4', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Climatempo', 'EQ-CEN-002', 'Ar Split 12K', 'REFRIGERACAO', 'STAND_BY', 'CABO'),
('1325be99-364b-4355-8884-c65516d085c0', 'e7d9c1a1-2f56-4f7b-8b9f-12c3f4c2a1b3', 'Belden', 'EQ-CEN-003', 'Cat6', 'TELEMETRICA', 'FUNCIONANDO', 'CABO');

-- Equipamentos da Estação Norte
INSERT INTO equipamento (id, fk_estacao, marca, codigo, modelo, categoria, status, tipo) VALUES
('2e542540-78cd-4c53-98cb-76a84b1060c5', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'CombinadorPro', 'EQ-NOR-001', 'Comb-900', 'TELEMETRICA', 'MANUTENCAO', 'COMBINADOR'),
('9e9bd96a-edfd-40d6-9d30-1472d045f450', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Schneider', 'EQ-NOR-002', 'Disjuntor 20A', 'ELETRICA', 'FUNCIONANDO', 'DISJUNTOR'),
('e0d699a2-5bc8-42d5-a574-0060f5fda386', 'f3c9e3d7-1b45-4d02-a0c1-3b4a12ef231d', 'Eaton', 'EQ-NOR-003', 'DPS 40kA', 'ELETRICA', 'DEFEITO', 'DPS');

-- Equipamentos da Estação Leste
INSERT INTO equipamento (id, fk_estacao, marca, codigo, modelo, categoria, status, tipo) VALUES
('47ae2514-f3d0-4978-b99e-89e0fe77cadf', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Ventisol', 'EQ-LES-001', 'Exaustor 30cm', 'REFRIGERACAO', 'FUNCIONANDO', 'EXAUSTOR'),
('5ff08b14-2fce-4038-82e3-383541a4f074', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'APC', 'EQ-LES-002', 'NoBreak 1000VA', 'ELETRICA', 'STAND_BY', 'NOBREAK'),
('b375e5c6-dee5-46e3-8bbc-20e8602a711a', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Hughes', 'EQ-LES-003', 'Parabólica P100', 'TELEMETRICA', 'MANUTENCAO', 'PARABOLICA'),
('a6206da2-f9bd-475d-8663-b262542116c4', 'a2f5f3e4-9d2c-42b1-a67f-2e3fa90df1cd', 'Schneider', 'EQ-LES-004', 'Quadro Elétrico Q1', 'ELETRICA', 'FUNCIONANDO', 'QUADRO');

INSERT INTO cabo (id, fk_equipamento, tipo, tamanho) VALUES
('4ae97c9f-ac8c-4300-a388-163c601f7319', '87815e08-0ff5-45cf-a596-79d430983f58', 'C_7_8', 15.5),
('8a6d8496-9217-4c02-aaf8-58f7b893bcbc', '4680e683-1708-42c7-8b0d-c70779137bf4', 'C_15_8', 30.0),
('b5db24cd-056f-4cb8-9ab3-1b28e5ff702f', '1325be99-364b-4355-8884-c65516d085c0', 'C_31_8', 45.75);





