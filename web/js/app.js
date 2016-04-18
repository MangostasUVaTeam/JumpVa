(function (){

    var app = angular.module('jumpva', ['ngRoute','ui.bootstrap','ngAnimate',
    'main', 'toolbar','mainContent', 'login', 'signin','unassigned-delivery' ]);

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
                transportista: "",
                pedido:{
                    descripcion: "tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "paquete"
                },
                pujas: [
                    {
                        transportista: "Paco",
                        precio: 50
                    },
                    {
                        transportista: "Juan",
                        precio: 65
                    },
                    {
                        transportista: "Luis",
                        precio: 32
                    },
                    {
                        transportista: "Miguel",
                        precio: 45
                    }
                ]
            },
            {
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "",
                pedido:{
                    descripcion: "tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "paquete"
                },
                pujas: [
                    {
                        transportista: "Paco",
                        precio: 50
                    },
                    {
                        transportista: "Paco",
                        precio: 50
                    },
                    {
                        transportista: "Paco",
                        precio: 50
                    },
                    {
                        transportista: "Juan",
                        precio: 65
                    },
                    {
                        transportista: "Luis",
                        precio: 32
                    },
                    {
                        transportista: "Miguel",
                        precio: 45
                    }
                ]
            },
            {
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "Paco",
                completado: 100,
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


    app.controller("ToolController", function($scope, logedUser){
        this.settings = logedUser;
    });


})();
