(function (){

    var app = angular.module('mainContent', ['jumpva']);


    app.controller("MainContentController", function($scope, deliveries, user, auth){
        var self = this;
        self.deliveries = null;


        user.getShipmentList()
            .then(handleRequest, handleRequest);

        function handleRequest(res) {
            self.deliveries = res.data.shipmentList;
        };


        this.getHTML= function(delivery){
            switch (delivery.state) {
                case "INPROGRESS":
                    return 'includes/inprogress-delivery.html';

                case "UNASSIGNED":
                    return 'includes/unassigned-delivery.html';

                case "COMPLETED":
                    return 'includes/completed-delivery.html';

                default:
                    return '';

            }
            /*
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
            */
        };

        this.getPanelClass = function(delivery){

            switch (delivery.state) {
                case "INPROGRESS":
                    return 'panel-info';

                case "UNASSIGNED":
                    return 'panel-warning';

                case "COMPLETED":
                    return 'panel-success';

                default:
                    return '';

            }
        };

    });
})();
