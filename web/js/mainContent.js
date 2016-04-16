(function (){

    var app = angular.module('mainContent', ['jumpva']);


    app.controller("MainContentController", ['$scope','logedUser',function($scope,logedUser){
        this.deliveries = logedUser.deliveries;

        for (delivery of logedUser.deliveries){
            delivery.dropdown = true;
        }
    }]);


    app.controller("DeliveryController", [ '$scope',function($scope){


        deliveryCtrl.toggleDropdown = function(delivery){
            if (delivery.dropdown){
                delivery.dropdown = false;
            } else {
                delivery.dropdown = true;
            }
        };
    }]);

})();
