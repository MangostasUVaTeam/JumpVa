(function (){

    var app = angular.module('mainContent', ['jumpva']);


    app.controller("MainContentController", function($scope,logedUser, deliveries){
        this.deliveries = deliveries;

        this.getHTML= function(delivery){
            if(delivery.transportista){
                if(delivery.completado == 100){
                    return 'includes/completed-delivery.html';
                } else {
                    return 'includes/inprogress-delivery.html';
                }
            } else {
                return 'includes/unassigned-delivery.html';
            }
        };

    });
})();
