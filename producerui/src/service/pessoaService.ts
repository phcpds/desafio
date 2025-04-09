import axios from "axios";
import { IPessoa } from "../model/pessoa";

export async function salvarPessoa(pessoa : IPessoa) {

    try {
        await axios.post('http://localhost:40001/api/pessoas', pessoa);
    } catch (err) {
        throw Error('Erro ao salvar a pessoa: ' + err)
    }

}