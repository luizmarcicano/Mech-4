///////////////////////////
//         CREATE        //
///////////////////////////

function fazPost(url, body){
    console.log("Body=", body)

    let request = new XMLHttpRequest()
    request.open("POST", url, true)
    request.setRequestHeader("Content-Type", "application/json")
    request.send(JSON.stringify(body))

    request.onload = function(){
        console.log(this.responseText)
    }
    return request.responseText
}

function cadastrarUsuario(){
    event.preventDefault()
    let url = "http://localhost:8080/api/v1/usuarios/";
    let nomeCompleto = document.getElementById('nomeCompleto').value
    let cidade = document.getElementById('cidade').value
    let estado = document.getElementById('estado').value
    let username = document.getElementById('username').value
    let senha = document.getElementById('password').value
    let dataNascimento = document.getElementById('dataNascimento').value

    console.log(nomeCompleto)
    console.log(cidade)
    console.log(estado)
    console.log(username)
    console.log(senha)
    console.log(dataNascimento)

    body = {
        "nomeCompleto": nomeCompleto,
        "cidade": cidade,
        "estado": estado,
        "username": username,
        "senha": senha,
        "dataNascimento": dataNascimento
    }

    fazPost(url, body)

}


















function adiconarUsuario() {
  
    console.log("chamou adicionar aluno");

    // Chamada à API
    fetch('http://localhost:8080/api/v1/usuarios/', {
        method: 'POST',
        headers: {
          'content-type': 'application/json'
        },
        body: {
          nomeCompleto: document.getElementById('nomeCompleto').value,
          cidade: document.getElementById('cidade').value,
          estado: document.getElementById('estado').value,
          username: document.getElementById('username').value,
          senha: document.getElementById('password').value,
          dtNascimento: document.getElementById('dtNascimento').value
        }
      })
        .then(response => {
          console.log(response)
        })
        .catch(err => {
          console.log(err)
        })
}

