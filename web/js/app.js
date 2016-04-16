(function (){

    var app = angular.module('jumpva', ['toolbar','mainContent', 'login']);

    app.value('logedUser', {
        username: "Paco",
        carrier: true
    });

    app.value('deliveries', [
            {
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "Paco",
                completado: 70,
                pedido:{
                    descripcion: "tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "paquete"
                },
                hitos:[
                        {
                            mensaje: "Dueñas, Palencia",
                            tipo: "location",
                            time: "",
                        }
                ]
            },
            {
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "Paco",
                completado: 70,
                pedido:{
                    descripcion: "tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "paquete"
                },
                hitos:[
                        {
                            mensaje: "Dueñas, Palencia",
                            tipo: "location",
                            time: "",
                        }
                ]
            },
            {
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "Paco",
                completado: 70,
                pedido:{
                    descripcion: "tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "paquete"
                },
                hitos:[
                        {
                            mensaje: "Dueñas, Palencia",
                            tipo: "location",
                            time: "",
                        }
                ]
            },
        ]
    );

    app.directive('jumpvaToolbar', function(){
        return {
            restrict: 'E',
            templateUrl: 'includes/toolbar.html'
        };
    });


    app.directive('jumpvaMainContent', function(){
        return {
            restrict: 'E',
            templateUrl: 'includes/main-content.html'
        };
    });

    app.directive('jumpvaMain', function(){
        return {
            restrict: 'E',
            templateUrl: 'includes/main.html'
        };
    });


    app.directive('jumpvaLogin', function(){
        return {
            restrict: 'E',
            templateUrl: 'includes/login.html'
        };
    });


    app.controller("ToolController", ['$scope', 'logedUser', function($scope, logedUser){
        this.settings = logedUser;
    }]);


})();
