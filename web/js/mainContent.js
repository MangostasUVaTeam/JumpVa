(function (){

    var app = angular.module('mainContent', ['jumpva']);


    app.controller("MainContentController", function($scope, user, auth){
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
                    switch (user.role) {
                        case "TRANSPORTISTA":
                            return 'includes/pending-to-assign-delivery.html';
                        case "CLIENTE":
                            return 'includes/unassigned-delivery.html';
                        default:
                            return '';
                    };
                case "COMPLETED":
                    return 'includes/completed-delivery.html';
                default:
                    return '';
            };
        }

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

            };
        };

    });
})();
