(function (){

    var app = angular.module('mainContent', ['jumpva']);


    app.controller("MainContentController", function($scope,logedUser, deliveries){
        this.deliveries = deliveries;

        for (delivery of deliveries){
            delivery.dropdown = false;
        }
    });


    app.controller("DeliveryController", function($scope){
        deliveryCtrl = this;

        deliveryCtrl.toggleDropdown = function(delivery){
            if (delivery.dropdown){
                delivery.dropdown = false;
            } else {
                delivery.dropdown = true;
            }
        };
    });

})();
