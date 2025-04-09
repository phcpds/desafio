import React, { useState } from 'react';
import axios from 'axios';
import { cpf } from 'cpf-cnpj-validator';
import { IPessoa, initPessoa } from '../model/pessoa';
import { salvarPessoa } from '../service/pessoaService';

const PessoaForm: React.FC = () => {
  const [form, setForm] = useState<IPessoa>(initPessoa);

  const [erro, setErro] = useState('');
  const [sucesso, setSucesso] = useState(false);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const validarEmail = (email: string) => {
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setErro('');
    setSucesso(false);

    if (!cpf.isValid(form.cpf)) {
      setErro('CPF inválido');
      return;
    }

    if (!validarEmail(form.email)) {
      setErro('E-mail inválido');
      return;
    }

    
    try {
        salvarPessoa(form);
        setSucesso(true);
        setForm(initPessoa);
    } catch (err) {
        setErro('Erro ao enviar os dados.');
    }    
  };

  return (
    <form onSubmit={handleSubmit} style={{display: 'flex', flexDirection:'column', width:'70%'}}>
      <h2>Cadastro de Pessoa</h2>

      <input className='input' name="nome" value={form.nome} onChange={handleChange} placeholder="Nome" required />
      <input className='input' name="cpf" value={form.cpf} onChange={handleChange} placeholder="CPF" required />
      <input className='input' name="email" value={form.email} onChange={handleChange} placeholder="E-mail" required />
      <input className='input' name="telefone" value={form.telefone} onChange={handleChange} placeholder="Telefone" required />

      <button className='button' type="submit">Cadastrar</button>

      {erro && <p style={{ color: 'red' }}>{erro}</p>}
      {sucesso && <p style={{ color: 'green' }}>Cadastro enviado com sucesso!</p>}
    </form>
  );
};

export default PessoaForm;
