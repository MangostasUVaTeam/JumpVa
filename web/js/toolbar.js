(function (){

    var app = angular.module('toolbar', [ ]);


    app.controller("SearchController", function($scope,logedUser){
        this.search = function(text){
            console.log(logedUser);
            console.log(text);
        };
    });


    app.controller("ButtonsController", function($scope,$uibModal, logedUser){
        var buttonsCtrl =this;
        buttonsCtrl.logedUser = logedUser;

        buttonsCtrl.searchDeliveries = function(){
            $uibModal.open({                
                templateUrl: 'includes/search-deliveries.html',
                controller: 'SearchDeliveriesController',
                resolve: {
                    logedUser: function () {
                        return buttonsCtrl.logedUser;
                    }
                }
            });
        };

        buttonsCtrl.createDelivery = function(){
            $uibModal.open({
                templateUrl: 'includes/create-delivery.html',
                controller: 'CreateDeliveryController',
                resolve: {
                    logedUser: function () {
                        return buttonsCtrl.logedUser;
                    }
                }
            });
        };

    });


    app.controller("UserDataController", function($scope,$location, logedUser){

        this.username = function(){
            return logedUser.username;
        };

        this.toggleCarrier = function(){
            logedUser.carrier = !logedUser.carrier;
        }

        this.logout = function(){
            logedUser = {};
            console.log("Logout");
            $location.path('/home');

        };

        this.carrier = function(){
            if (logedUser.carrier){
                return "Transportista";
            } else {
                return "Cliente";
            }
        };
    });
})();
