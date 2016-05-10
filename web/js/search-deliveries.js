(function (){

    var app = angular.module('search-deliveries', ['jumpva']);

    app.controller('SearchDeliveriesController', function ($uibModalInstance,$uibModal,user  ) {

        var self = this;

        user.getUnassignedShipmentList(self.origin)
            .then(handleRequest, handleRequest);

        function handleRequest(res) {
            self.unassignedDeliveries = res.data.shipmentList;
            console.log(res.data);
        };

        self.origin = "Valladolid"

        self.cancel = function () {
            $uibModalInstance.close();
        };

        self.setOver = function(delivery) {
            self.origin = delivery.origin;
            self.destination = delivery.destination;
        }

        self.bid = function(delivery){
            var modalInstance = $uibModal.open({
              templateUrl: 'includes/confirm-bid.html',
              controller: 'ConfirmBidController as confirmBidCtrl',
              resolve: {
                  delivery: function () {
                    return delivery;
                  },

              }
            });


            modalInstance.result.then(function (selectedItem) {
                self.selected = selectedItem;

                if (selectedItem === 'confirm'){
                    self.unassignedDeliveries.splice(
                        self.unassignedDeliveries.indexOf(delivery),
                        1
                    );
                }
            });

        }
    });

    app.controller('ConfirmBidController', function ($uibModalInstance, delivery) {
        var self = this;

        self.delivery = delivery;

        self.confirm = function(){
            console.log('Confimado');
            $uibModalInstance.close('confirm');
        };

        self.cancel = function() {
            console.log('No Confimado');
            $uibModalInstance.close('cancel');
        };
    });


})();
