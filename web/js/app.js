(function (){

    var app = angular.module('jumpva', ['ngRoute','ui.bootstrap','ngAnimate', 'ngMap','number-input',
    'main', 'toolbar','mainContent', 'login', 'signin','unassigned-delivery',
    'completed-delivery','search-deliveries' ]);

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
                hitos:[],
                pujas: [
                    {
                        transportista: "Paco",
                        valoracion: 3,
                        precio: 50
                    },
                    {
                        transportista: "Juan",
                        valoracion: 3,
                        precio: 65
                    },
                    {
                        transportista: "Luis",
                        valoracion: 3,
                        precio: 32
                    },
                    {
                        transportista: "Miguel",
                        valoracion: 3,
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
                hitos:[],
                pujas: [
                    {
                        transportista: "Paco",
                        valoracion: 3,
                        precio: 50
                    },
                    {
                        transportista: "Paco",
                        valoracion: 3,
                        precio: 50
                    },
                    {
                        transportista: "Paco",
                        valoracion: 3,
                        precio: 50
                    },
                    {
                        transportista: "Juan",
                        valoracion: 3,
                        precio: 65
                    },
                    {
                        transportista: "Luis",
                        valoracion: 3,
                        precio: 32
                    },
                    {
                        transportista: "Miguel",
                        valoracion: 3,
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
                            mensaje: "Envío asignado",
                            tipo: "evento",
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



})();
