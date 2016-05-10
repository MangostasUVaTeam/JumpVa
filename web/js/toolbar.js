(function (){

    var app = angular.module('toolbar', [ ]);


    app.controller("SearchController", function($scope){
        this.search = function(text){
            console.log(text);
        };
    });


    app.controller("ButtonsController", function($scope,$uibModal, user){
        var buttonsCtrl =this;
        buttonsCtrl.isCarrier = function(){
            if (user.user.role === "TRANSPORTISTA"){
                return true;
            } else {
                return false;
            }
        };

        buttonsCtrl.searchDeliveries = function(){
            $uibModal.open({
                templateUrl: 'includes/search-deliveries.html',
                controller: 'SearchDeliveriesController as searchDeliveriesCtrl',
            });
        };

        buttonsCtrl.createDelivery = function(){
            $uibModal.open({
                templateUrl: 'includes/create-delivery.html',
                controller: 'CreateDeliveryController as createDeliveryCtrl',
            });
        };

    });


    app.controller("UserDataController", function($scope,$location, user, auth){


        this.username = function(){
            return user.user.name;
        };

        this.logout = function(){
            auth.logout && auth.logout();

            console.log("Logout");
            $location.path('/home');

        };

        this.carrier = function(){
            return user.user.role;
        };
    });
})();
