(function (){

    var app = angular.module('user-info', ['jumpva']);


    app.controller("UserInfoController", function($scope,$location,logedUser){
        console.log("hola");
        this.user = {
            username: "Paco",
            valoracion: 4.34,
            carrier: true,
            enviosRealizados: 342,
            fechaRegistro: Date.now()
        };

        this.getRol = function(user){
            if (user.carrier){
                return 'Transportista';
            } else {
                return 'Cliente';
            }

        };

    });
})();
