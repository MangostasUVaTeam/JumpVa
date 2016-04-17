(function (){

    var app = angular.module('jumpva', ['ngRoute','ui.bootstrap',
    'main', 'toolbar','mainContent', 'login', 'signin' ]);

    app.config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
                when('/login', {
                    templateUrl: 'includes/login.html',
                }).

                when('/signin', {
                    templateUrl: 'includes/signin.html',
                }).

                when('/main', {
                    templateUrl: 'includes/main.html',
                }).
                otherwise({
                    redirectTo: '/login'
                });
    }]);


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


    app.controller("ToolController", ['$scope', 'logedUser', function($scope, logedUser){
        this.settings = logedUser;
    }]);


})();
