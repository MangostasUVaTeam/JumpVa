(function (){

    var app = angular.module('home', ['jumpva']);


    app.controller("HomeController", function($scope,$location, $uibModal,$anchorScroll, deliveries){

        var loginCtrl = this;


        this.login = function(){
            $uibModal.open({
                templateUrl: 'includes/login.html',
                controller: 'LoginController',
            });
        };

        this.signin = function(){
            $uibModal.open({
                controller: 'SigninController',
                templateUrl: 'includes/signin.html',
            });
        };

        this.loginCarrier = function(){

            deliveries.push({
                origen: "Logroño",
                destino: "Paredes de nava",
                transportista: "",
                pendiente: true,
                puja: {
                    precio: 50,
                    date: Date.now()
                },
                pedido:{
                    descripcion: "tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "paquete",
                    imagen : "images/tomates.jpg",
                },
                hitos:[
                        {
                            mensaje: "Creacion del envío",
                            tipo: "time",
                            time: Date.now()
                        }
                ]
            });


            deliveries.push({
                origen: "Valladolid",
                destino: "Paredes de nava",
                transportista: "",
                pendiente: true,
                puja: {
                    precio: 50,
                    date: Date.now()
                },
                pedido:{
                    descripcion: "tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "paquete",
                    imagen : "images/tomates.jpg"
                },
                hitos:[
                        {
                            mensaje: "Creacion del envío",
                            tipo: "time",
                            time: Date.now()
                        }
                ]
            });


            deliveries.push({
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "Paco",
                completado: 100,
                pedido:{
                    descripcion: "Tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "Paquete",
                    imagen : "images/tomates.jpg"
                },
                hitos:[
                        {
                            mensaje: "Envío Completado",
                            tipo: "success",
                            time: "15:30",
                        }

                ]
            });


            deliveries.push({
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "Paco",
                completado: 70,
                pedido:{
                    descripcion: "Tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "Paquete",
                    imagen : "images/tomates.jpg"
                },
                hitos:[
                        {
                            mensaje: "Saliendo de Zaratan, Valladolid.",
                            tipo: "success",
                            time: "",
                            posicion: "pull-left"
                        },

                        {
                            mensaje: "De acuerdo, gracias.",
                            tipo: "",
                            time: "15:30",
                            posicion: "pull-right"
                        },

                        {
                          mensaje: "El envío llegara el Martes.",
                          tipo: "success",
                          time: "",
                          posicion: "pull-left"
                        }
                ]
            });



            console.log("gola");
            $location.path('/main');
        }

        this.loginClient = function(){


            deliveries.push({
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "Paco",
                completado: 100,
                pedido:{
                    descripcion: "Tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "Paquete",
                    imagen : "images/tomates.jpg"
                },
                hitos:[
                        {
                            mensaje: "Envío Completado",
                            tipo: "success",
                            time: "15:30",
                        }

                ]
            });


            deliveries.push({
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "Paco",
                completado: 70,
                pedido:{
                    descripcion: "Tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "Paquete",
                    imagen : "images/tomates.jpg"
                },
                hitos:[
                        {
                            mensaje: "Saliendo de Zaratan, Valladolid.",
                            tipo: "success",
                            time: "",
                            posicion: "pull-left"
                        },

                        {
                            mensaje: "De acuerdo, gracias.",
                            tipo: "",
                            time: "15:30",
                            posicion: "pull-right"
                        },

                        {
                          mensaje: "El envío llegara el Martes.",
                          tipo: "success",
                          time: "",
                          posicion: "pull-left"
                        }
                ]
            });


            deliveries.push({
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "",
                pedido:{
                    descripcion: "tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "paquete",
                    imagen : "images/tomates.jpg"
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
            });

            deliveries.push(
            {
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "",
                pedido:{
                    descripcion: "Tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "Paquete",
                    imagen : "images/tomates.jpg"
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
            });

            console.log("gola");
            $location.path('/main');
        }

    });
})();
