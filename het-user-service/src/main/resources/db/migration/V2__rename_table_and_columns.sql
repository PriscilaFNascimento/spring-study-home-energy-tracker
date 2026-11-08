ALTER TABLE applicationuser
RENAME TO "applicationUser";

ALTER TABLE "applicationUser"
RENAME COLUMN hasAlertEnabled TO has_alert_enabled;

ALTER TABLE "applicationUser"
RENAME COLUMN energyAlertingThreshold TO energy_alerting_threshold;