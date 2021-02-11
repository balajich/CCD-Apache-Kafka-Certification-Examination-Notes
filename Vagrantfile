# vi: set ft=ruby :

ENV['VAGRANT_NO_PARALLEL'] = 'yes'

Vagrant.configure(2) do |config|
  
  config.vm.define "kserver" do |kserver|
    kserver.vm.box = "centos/7"
    kserver.vm.hostname = "kserver.eduami.org"
    kserver.vm.network "private_network", ip: "192.168.50.26"
    kserver.vm.network "forwarded_port", guest: 9021, host: 9021 # Confluent Control Center
    kserver.vm.provision "shell", path: "startup-kserver.sh"
    kserver.vm.provider "virtualbox" do |vb|
      vb.name = "kserver"
      vb.memory = 6072
      vb.cpus = 1
    end
  end
end
