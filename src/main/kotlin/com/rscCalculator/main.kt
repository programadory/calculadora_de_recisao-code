import java.util.Scanner 

fun getInt(): Int {
    val num = Scanner(System.`in`)
    return num.nextInt()
}

fun showandGet(text: String, udata: MutableList<String> = mutableListOf()) {
  
    print(text)
    udata.add(readLine()!!)
}

fun main(){
  
  var saldoSalario: Double 
  val decimoTer: Double
  val feriasVP: Double
  val avisoPrevio: Int
  val avisoPrevioI: Double
  
  val userData: MutableList<String> = mutableListOf()
  
  println("\n-----------CALCULADORA DE RESCISAO TRABALHISTA-------------\n\n")
  
  showandGet("Nome: ", userData) //0
  showandGet("Tipo de contrato: ", userData) //1
  showandGet("Data de admissao: ", userData) //2
  showandGet("Data de aviso previo/afastamento: ", userData)//3
  showandGet("Codigo de afastamento: ", userData)//4
  showandGet("Ultima remuneracao bruta: ", userData)//5
  showandGet("Meses trabalhados: ", userData)//6
  showandGet("Dias trabalhados no mes: ", userData)//7
  showandGet("Ferias Vencidas [sim/nao]: ", userData)//8
  showandGet("Ferias Acumuladas: [anos]: ", userData)
  
  /*Saldo de salario*/
  saldoSalario = String.format("%.2f", (userData[5].toDouble()/30)*userData[7].toDouble()).toDouble()
   /*Decimo Terceiro = (Salario mensal / 12) x numero de meses trabalhados*/
   decimoTer = String.format("%.2f", (userData[5].toDouble()/12)*userData[6].toDouble()).toDouble()
   
  /*Ferias vencidas/Proporcionais
  Férias Vencidas = [(salário integral x 1/3) x 2] x n */
  if(userData[8]=="sim"){
      feriasVP = String.format("%.2f", (userData[5].toDouble()*1/3)*2).toDouble()
  }
  else if(userData[8]=="sim" && userData[9].toInt() > 1){
      feriasVP = String.format("%.2f", ((userData[5].toDouble()*1/3)*2)*userData[9].toDouble()).toDouble()
  }
  else {
      feriasVP = String.format("%.2f", (userData[5].toDouble()*userData[6].toDouble())/12+1/3).toDouble()
  }
  
  /*Aviso Previo Indenizado = 30 + (3 x N anos trabalhados) 
Aviso Previo = Aviso Previo Indenizado x (Salario / 30 dias)*/
  if(userData[6].toInt()>=12){
      var it: Int = 0
      var itYears: Int  = 0
      var years: Int = 1
      while(it++ <= userData[6].toInt()){
          if(itYears==12){
              years++
              itYears=0
          }
          itYears++
      }
      /*Aviso previo*/
      avisoPrevio = 30+(3*years)
      /*Aviso previo indenizado*/
      avisoPrevioI = String.format("%.2f", avisoPrevio.toDouble()*(userData[5].toDouble()/30)).toDouble()
  }else{
    avisoPrevio = 0
    avisoPrevioI = 0.0
  }
  
  println("\nO seu Saldo de salario e de: ${saldoSalario}R$")
  println("${userData[6]} meses e ${userData[7]}  dias trabalhados\n")
  println(if(userData[8]=="sim") "O saldo de ferias vencidas e: ${feriasVP}R$" else "O saldo de ferias proporcionais e: ${feriasVP}R$\n")
  println("Valor do 13th salarios: ${decimoTer}R$\n")
  
  println("Saldo de aviso previo: ${avisoPrevio}R$\nSaldo de aviso previo indenizado: ${avisoPrevioI}R$\n")
  
  
 /*
 PEDIDO DE DEMISSAO - Saldo de salario,
                   - 13th salario proporcional.
                   - Ferias Vencidas & Ferias proporcionais +1/3
*/
}
/* TIPO (3) = ENUM/STRING/LIST
CAUSA DE AFASTAMENTO (PD0) = ENUM/STRING
REMUNERACAO MES ANT = DOUBLE
DATA ADIMISSAO = DATA_TYPsE/DOUBLE/ARRAY-LIST
DATA DE AVISO PREVIO = DATA_TYPE/DOUBLE/ARRAY-LIST
DATA DE AFASTAMENTO = DATA_TYPE/DOUBLE/ARRAY-LIST
CODIGO AFASTAMENTO (PD0) = STRING/ENUM
PENSAO ALIM (% TRCT) = DOUBLE
PENSAO ALIM (% FGTS) = DOUBLE 
CATEGORIA FUNCIONARIO (O1) = STRING/ENUM 
CODIGO SINDICAL = LONG/DOUBLE/ARRAY-LIST
CNPJ SINDICATO = PAIR/STRING/ARRAY-LIST
*/