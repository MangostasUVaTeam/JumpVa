(function (){

    var app = angular.module('millestone-delivery', []);

    app.controller("MillestoneController", function (user) {
        var self = this;

        self.nuevoHito = null;

        self.addMilestone = function(shipment){
              console.log(self.newMilestone.body);

              self.newMilestone.date = Date.now();

              user.postNewHitoToShipment(shipment, self.newMilestone);

              self.newMilestone = null;

        };

    });
})();
