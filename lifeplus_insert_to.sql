CREATE SCHEMA lifeplus;

select * from medicamentos_med_injetaveis;

select * from medicamentos;

insert into medicamentos(id, nome, concentracao, apresentacao, qtd_por_unidade, marca, descricao, preco, preco_com_desconto) values
(1, 'Paracetamol', '500mg', 'Comprimido', 20, 'MedPharma', 'Alívio temporário de dores de cabeça, dores musculares e febre.', 15.99, 12.99),
(2, 'Amoxicilina', '250mg', 'Cápsula', 30, 'Farmalife', 'Antibiótico de amplo espectro para tratamento de infecções bacterianas.', 25.50, 20.99),
(3, 'Omeprazol', '20mg', 'Cápsula', 14, 'PharmaPlus', 'Reduz a produção de ácido no estômago, indicado para úlceras gástricas e refluxo.', 18.75, 14.99),
(4, 'Dipirona', '500mg', 'Comprimido', 30, 'Medicor', 'Analgésico e antitérmico para alívio de dores e febre.', 12.99, 9.99),
(5, 'Dorflex', '300mg + 35mg', 'Comprimido', 10, 'PharmaCure', 'Relaxante muscular indicado para o tratamento de dores musculares e tensões.', 27.50, 22.99),
(6, 'Cloridrato de Propranolol', '40mg', 'Comprimido', 30, 'Genérico', 'Indicado para controle da pressão arterial e prevenção de ataques cardíacos.', 21.30, 16.99),
(7, 'Fluconazol', '150mg', 'Cápsula', 4, 'BioMed', 'Antifúngico utilizado no tratamento de infecções causadas por fungos.', 14.99, 11.99),
(8, 'Cetirizina', '10mg', 'Comprimido', 20, 'MedPharma', 'Anti-histamínico utilizado para aliviar sintomas de alergias como rinite e urticária.', 9.99, 7.99),
(9, 'Prednisona', '5mg', 'Comprimido', 50, 'Farmalife', 'Corticosteroide utilizado para reduzir inflamações e aliviar sintomas de diversas doenças.', 16.50, 12.99),
(10, 'Clonazepam', '2mg', 'Comprimido', 60, 'PharmaPlus', 'Ansiolítico e anticonvulsivante indicado para tratamento de ansiedade e epilepsia.', 23.99, 18.99);


select * from medicamentos_injetaveis;

insert into medicamentos_injetaveis(id, nome, concentracao, apresentacao, qtd_por_unidade, marca, descricao, preco, preco_com_desconto, tipo_de_aplicacao) values
(11, 'Dipirona Sódica', '500mg/ml', 'Ampola', 10, 'MedPharma', 'Analgésico e antitérmico injetável para alívio de dores e febre.', 19.99, 15.99, 'Intramuscular'),
(12, 'Metamizol Sódico', '1g/2ml', 'Ampola', 5, 'Farmalife', 'Analgésico e antipirético utilizado para controle de dores intensas e febre.', 25.50, 20.99, 'Endovenosa'),
(13, 'Dexametasona', '4mg/ml', 'Ampola', 20, 'PharmaPlus', 'Corticosteroide utilizado para reduzir inflamações e tratar diversas condições médicas.', 18.75, 14.99, 'Intradérmica'),
(14, 'Ampicilina Sódica', '500mg', 'Ampola', 25, 'Medicor', 'Antibiótico de amplo espectro para tratamento de infecções bacterianas.', 12.99, 9.99, 'Subcutânea'),
(15, 'Sulfato de Magnésio', '10% - 2ml', 'Ampola', 10, 'PharmaCure', 'Suplemento de magnésio utilizado em casos de deficiência ou tratamento de condições específicas.', 27.50, 22.99, 'Intramuscular'),
(16, 'Cloridrato de Tramadol', '50mg/ml', 'Ampola', 10, 'Genérico', 'Analgésico opioide utilizado para o tratamento de dores moderadas a graves.', 21.30, 16.99, 'Endovenosa'),
(17, 'Haloperidol', '5mg/ml', 'Ampola', 5, 'BioMed', 'Antipsicótico utilizado para o tratamento de transtornos mentais como esquizofrenia e agitação.', 14.99, 11.99, 'Intramuscular'),
(18, 'Cloridrato de Prometazina', '50mg/ml', 'Ampola', 10, 'MedPharma', 'Antialérgico e antiemético utilizado no controle de alergias e náuseas.', 9.99, 7.99, 'Endovenosa'),
(19, 'Fosfato de Sódio Monobásico', '15mmol/5ml', 'Ampola', 20, 'Farmalife', 'Laxante utilizado para o esvaziamento intestinal antes de procedimentos médicos.', 16.50, 12.99, 'Intradérmica'),
(20, 'Succinato de Metilprednisolona', '40mg/ml', 'Ampola', 10, 'PharmaPlus', 'Corticosteroide utilizado para reduzir inflamações e tratar diversas condições médicas.', 23.99, 18.99, 'Subcutânea');
