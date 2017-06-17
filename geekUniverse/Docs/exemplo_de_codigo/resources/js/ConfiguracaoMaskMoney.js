//Configuração do Plugin Jquery MaskMoney
//link para download e exemplos de uso http://plentz.github.io/jquery-maskmoney/

//A configuração abaixo é para o real brasileiro

$(function(){
    $('#valor').maskMoney({thousands:'.', decimal:',', prefix:'R$', affixesStay: true, allowZero: false , allowNegative: false, precision: 2});
})
