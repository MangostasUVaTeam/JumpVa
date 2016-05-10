(function (){

    var app = angular.module('mainContent', ['jumpva']);


    app.controller("MainContentController", function($scope,logedUser, deliveries, user, auth){
        var self = this;
        self.deliveries = null;


        user.getShipmentList()
            .then(handleRequest, handleRequest);

        function handleRequest(res) {
            self.deliveries = res.data.shipmentList;
        };


        this.getHTML= function(delivery){
            if(delivery.transportista){
                if(delivery.completado == 100){
                    return 'includes/completed-delivery.html';
                } else {
                    return 'includes/inprogress-delivery.html';
                }
            } else if (delivery.pendiente) {
                return 'includes/pending-to-assign-delivery.html';

            } else {
                return 'includes/unassigned-delivery.html';
            }
        };

        this.getPanelClass = function(delivery){
            if(delivery.transportista){
                if ( (delivery.completado == 100) || (delivery.pendiente) ){
                    return 'panel-success';
                } else {
                    return 'panel-info';
                }
            } else {
                return 'panel-warning';
            }
        };

    });
})();
